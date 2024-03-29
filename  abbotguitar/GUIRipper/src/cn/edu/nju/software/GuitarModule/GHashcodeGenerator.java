/*  
 
 
 * 
 
 *  documentation files (the "Software"), to deal in the Software without restriction, including without 
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *  the Software, and to permit persons to whom the Software is furnished to do so, subject to the following 
 *  conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all copies or substantial 
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 *  LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO 
 *  EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR 
 *  THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package cn.edu.nju.software.GuitarModule;

import cn.edu.nju.software.ripperModuleData.ComponentType;
import cn.edu.nju.software.ripperModuleData.GUIType;

/**
 * Interface for different hash code generating algorithms of GUITAR components.
 * The hash code will be used to identify GUI component on the entire GUI
 * 
 *  <p>
 * 
 * @author  </a>
 * 
 */
public abstract class GHashcodeGenerator {

	/**
	 * Get hash code from xml data's properties
	 * 
	 * @param dComponent
	 * @param dWindow
	 * @return
	 * 	the component's hash code
	 */
	abstract public long getHashcodeFromData(ComponentType dComponent,
			GUIType dWindow);

	abstract public long getHashcodeFromGUI(GComponent gComponent,
			GWindow gWindow);

}
