/*
 *  Copyright (c) 2009-@year@. The  GUITAR group  at the University of
 *  Maryland. Names of owners of this group may be obtained by sending
 *  an e-mail to atif@cs.umd.edu
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files
 *  (the "Software"), to deal in the Software without restriction,
 *  including without limitation  the rights to use, copy, modify, merge,
 *  publish,  distribute, sublicense, and/or sell copies of the Software,
 *  and to  permit persons  to whom  the Software  is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included
 *  in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 *  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY,  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  IN NO  EVENT SHALL THE  AUTHORS OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY
 *  CLAIM, DAMAGES OR  OTHER LIABILITY,  WHETHER IN AN  ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 *  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package cn.edu.nju.software.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.nju.software.model.data.AttributesType;
import cn.edu.nju.software.model.data.ComponentType;
import cn.edu.nju.software.model.data.ContainerType;
import cn.edu.nju.software.model.data.GUIStructure;
import cn.edu.nju.software.model.data.GUIType;
import cn.edu.nju.software.model.data.ObjectFactory;
import cn.edu.nju.software.model.data.PropertyType;
import cn.edu.nju.software.model.wrapper.AttributesTypeWrapper;
import cn.edu.nju.software.model.wrapper.ComponentTypeWrapper;
import cn.edu.nju.software.model.wrapper.GUITypeWrapper;
import cn.edu.nju.software.util.AppUtil;

/**
 * Default ID generator for JFC application
 * 
 * @author   Bao N. Nguyen </a>
 * 
 */
public class JFCDefaultIDGeneratorSimple implements GIDGenerator {
	static JFCDefaultIDGeneratorSimple instance = null;
	static ObjectFactory factory = new ObjectFactory();
	static final int prime = 31;

	public static JFCDefaultIDGeneratorSimple getInstance() {
		if (instance == null) {
			instance = new JFCDefaultIDGeneratorSimple();
		}

		return instance;
	}

	private JFCDefaultIDGeneratorSimple() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.umd.cs.guitar.model.GIDGenerator#genID(edu.umd.cs.guitar.model.data
	 * .GUIStructure)
	 */
	@Override
	public void generateID(GUIStructure gs) {
		for (GUIType gui : gs.getGUI()) {
			generateGUIID(gui);
		}
	}

	/**
	 * @param gui
	 */
	private void generateGUIID(GUIType gui) {
		ContainerType container = gui.getContainer();

		if (container == null) {
			return;
		}

		long windowHashCode = getWindowHashCode(gui);

		List<ComponentType> subComponentList = container.getContents()
				.getWidgetOrContainer();

		if (subComponentList == null) {
			return;
		}

		for (ComponentType subComponent : subComponentList) {
			// Generate first container hash code specially to ignore window
			// susceptible to title change

			AttributesType attributes = subComponent.getAttributes();
			long hashcode = windowHashCode;
			if (attributes != null) {

				String sID = GUITARConstants.COMPONENT_ID_PREFIX + hashcode;

				List<PropertyType> lProperty = new ArrayList<PropertyType>();

				for (PropertyType p : attributes.getProperty()) {
					if (!GUITARConstants.ID_TAG_NAME.equals(p.getName())) {
						lProperty.add(p);
					}
					if (GUITARConstants.TITLE_TAG_NAME.equals(p.getName())) {
						System.out.println ("generateGUIID: " + "[" + sID
								+ "] " + p.getValue() + "windowHashCode "
								+ windowHashCode);
					}
				}

				PropertyType property = factory.createPropertyType();
				property.setName(GUITARConstants.ID_TAG_NAME);
				property.getValue().add(sID);
				lProperty.add(0, property);
				attributes.setProperty(lProperty);

			}

			if (subComponent instanceof ContainerType) {
				ContainerType subContainer = (ContainerType) subComponent;
				for (ComponentType component : subContainer.getContents()
						.getWidgetOrContainer()) {
					generateComponentID(component, hashcode);
				}
			}
		}
	}

	/**
	 * Compute hash code for given GUIType.
	 * 
	 * A hashcode is computer for the given GUIType. First an attempt is made to
	 * match the title of the input 'gui' into a pre-defined set of regex. If a
	 * match is found, then the regex is used for generating the hashcode.
	 * 
	 * @param gui
	 *            GUIType shows hashcode is to be generated
	 * @return Hashcode for the input GUIType
	 */
	private long getWindowHashCode(GUIType gui) {
		GUITypeWrapper wGUI = new GUITypeWrapper(gui);
		String title = wGUI.getTitle();
		AppUtil appUtil = new AppUtil();

		System.out.println("SSS " + title);
		String fuzzyTitle = appUtil.findRegexForString(title);

		long hashcode = fuzzyTitle.hashCode();

		hashcode = (hashcode * 2) & 0xffffffffL;

		return hashcode;
	}

	private void generateComponentID(ComponentType component, long windoHashCode) {
		AttributesType attributes = component.getAttributes();

		long hashcode = 1;

		if (attributes != null) {

			long localHashCode = getLocalHashcode(component);
			hashcode = windoHashCode * prime + localHashCode;
			hashcode = (hashcode * 2) & 0xffffffffL;

			String sID = GUITARConstants.COMPONENT_ID_PREFIX + hashcode;

			List<PropertyType> lProperty = new ArrayList<PropertyType>();

			for (PropertyType p : attributes.getProperty()) {
				if (!GUITARConstants.ID_TAG_NAME.equals(p.getName())) {
					lProperty.add(p);
				}
				if (GUITARConstants.TITLE_TAG_NAME.equals(p.getName())) {
					System.out.println("generateComponentID " + "[" + sID
							+ "] " + p.getValue() + "windoHashCode "
							+ windoHashCode + "localHashCode " + localHashCode);
				}
			}

			PropertyType property = factory.createPropertyType();
			property.setName(GUITARConstants.ID_TAG_NAME);
			property.getValue().add(sID);
			lProperty.add(0, property);
			attributes.setProperty(lProperty);

		} else {
			hashcode = windoHashCode;
		}

		if (component instanceof ContainerType) {
			ContainerType container = (ContainerType) component;
			List<ComponentType> children = container.getContents()
					.getWidgetOrContainer();

			boolean isAddIndex;

			for (ComponentType child : children) {

				// Debug
				ComponentTypeWrapper wChild = new ComponentTypeWrapper(child);

				String sClass = wChild
						.getFirstValueByName(GUITARConstants.CLASS_TAG_NAME);

				Integer index = children.indexOf(child);
				long propagatedHashCode = prime * windoHashCode
						+ index.hashCode();

				generateComponentID(child, propagatedHashCode);
			}
		}
	}

	/**
	 * @param component
	 * @return
	 */
	private boolean hasUniqueChildren(ComponentType component) {
		if (!(component instanceof ContainerType)) {
			return true;
		}

		List<Long> examinedHashCode = new ArrayList<Long>();

		ContainerType container = (ContainerType) component;
		for (ComponentType child : container.getContents()
				.getWidgetOrContainer()) {
			long hashcode = getLocalHashcode(child);
			if (examinedHashCode.contains(hashcode)) {
				return false;
			} else {
				examinedHashCode.add(hashcode);
			}
		}

		return true;
	}

	static List<String> ID_PROPERTIES = new ArrayList<String>(
			JFCConstants.ID_PROPERTIES);

	/**
	 * Those classes are invisible widgets but cause false-positive when
	 * calculating ID
	 */
	static List<String> IGNORED_CLASSES = Arrays.asList("javax.swing.JPanel",
			"javax.swing.JTabbedPane", "javax.swing.JScrollPane",
			"javax.swing.JSplitPane", "javax.swing.Box",
			"javax.swing.JViewport", "javax.swing.JScrollBar",
			"javax.swing.JLayeredPane",
			"javax.swing.JList$AccessibleJList$AccessibleJListChild",
			"javax.swing.JList$AccessibleJList", "javax.swing.JList",
			"javax.swing.JScrollPane$ScrollBar",
			"javax.swing.plaf.metal.MetalScrollButton");

	/**
	 * Those classes are invisible widgets but cause false-positive when
	 * calculating ID
	 */
	static List<String> IS_ADD_INDEX_CLASSES = Arrays
			.asList("javax.swing.JTabbedPane$Page");

	/**
	 * @param component
	 * @return
	 */
	private long getLocalHashcode(ComponentType component) {
		final int prime = 31;

		long hashcode = 1;

		AttributesType attributes = component.getAttributes();
		if (attributes == null) {
			return hashcode;
		}

		// Specially handle titles
		AttributesTypeWrapper wAttribute = new AttributesTypeWrapper(attributes);
		String sClass = wAttribute
				.getFirstValByName(GUITARConstants.CLASS_TAG_NAME);

		if (IGNORED_CLASSES.contains(sClass)) {
			hashcode = (prime * hashcode + (sClass == null ? 0 : (sClass
					.hashCode())));
			return hashcode;
		}

		// Normal cases
		// Using ID_Properties for hash code

		List<PropertyType> lProperty = attributes.getProperty();

		if (lProperty == null) {
			return hashcode;
		}

		for (PropertyType property : lProperty) {

			String name = property.getName();
			if (ID_PROPERTIES.contains(name)) {

				hashcode = (prime * hashcode + (name == null ? 0 : name
						.hashCode()));

				List<String> valueList = property.getValue();
				if (valueList != null) {
					for (String value : valueList) {
						hashcode = (prime * hashcode + (value == null ? 0
								: (value.hashCode())));

					}
				}
			}
		}

		hashcode = (hashcode * 2) & 0xffffffffL;

		return hashcode;

	}

} // End of class
