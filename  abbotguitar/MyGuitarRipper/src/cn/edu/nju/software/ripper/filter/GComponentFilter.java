/*	
 *  Copyright (c) 2009-@year@. The GUITAR group at the University of Maryland. Names of owners of this group may
 *  be obtained by sending an e-mail to atif@cs.umd.edu
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 *  documentation files (the "Software"), to deal in the Software without restriction, including without 
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *	the Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 *	conditions:
 * 
 *	The above copyright notice and this permission notice shall be included in all copies or substantial 
 *	portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 *	LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO 
 *	EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
 *	IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 *	THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package cn.edu.nju.software.ripper.filter;

import cn.edu.nju.software.model.GComponent;
import cn.edu.nju.software.model.GWindow;
import cn.edu.nju.software.model.data.ComponentType;
import cn.edu.nju.software.ripper.Ripper;

/**
 *   
 * An interface for component filters. Component filters are used 
 * to change the ripper behavior for special components. For example,
 * some components need to be ignored or just captured the GUI information 
 * instead of trying to click on them (e.g., links to external web site).
 * 
 * <p>
 *   
 * @author <a href="mailto:baonn@cs.umd.edu"> Bao Nguyen </a>
 *
 */
public abstract class GComponentFilter {
	
	Ripper ripper;

	/**
	 * @param ripper the ripper to set
	 */
	public void setRipper(Ripper ripper) {
		this.ripper = ripper;
	}

	public abstract boolean isProcess(GComponent component, GWindow window );
	
	public abstract ComponentType ripComponent(GComponent component, GWindow window);

}
