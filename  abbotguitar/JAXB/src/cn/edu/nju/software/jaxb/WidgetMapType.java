//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.04 at 04:13:40 ���� CST 
//


package cn.edu.nju.software.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WidgetMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WidgetMapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WidgetMapElement" type="{}WidgetMapElementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WidgetMapType", propOrder = {
    "widgetMapElement"
})
public class WidgetMapType {

    @XmlElement(name = "WidgetMapElement")
    protected List<WidgetMapElementType> widgetMapElement;

    /**
     * Gets the value of the widgetMapElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the widgetMapElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidgetMapElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WidgetMapElementType }
     * 
     * 
     */
    public List<WidgetMapElementType> getWidgetMapElement() {
        if (widgetMapElement == null) {
            widgetMapElement = new ArrayList<WidgetMapElementType>();
        }
        return this.widgetMapElement;
    }

}
