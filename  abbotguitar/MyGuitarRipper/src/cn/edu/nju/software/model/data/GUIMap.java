//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.04 at 04:13:40 ���� CST 
//


package cn.edu.nju.software.model.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EventMap" type="{}EventMapType"/>
 *         &lt;element name="WidgetMap" type="{}WidgetMapType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eventMap",
    "widgetMap"
})
@XmlRootElement(name = "GUIMap")
public class GUIMap {

    @XmlElement(name = "EventMap", required = true)
    protected EventMapType eventMap;
    @XmlElement(name = "WidgetMap", required = true)
    protected WidgetMapType widgetMap;

    /**
     * Gets the value of the eventMap property.
     * 
     * @return
     *     possible object is
     *     {@link EventMapType }
     *     
     */
    public EventMapType getEventMap() {
        return eventMap;
    }

    /**
     * Sets the value of the eventMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventMapType }
     *     
     */
    public void setEventMap(EventMapType value) {
        this.eventMap = value;
    }

    /**
     * Gets the value of the widgetMap property.
     * 
     * @return
     *     possible object is
     *     {@link WidgetMapType }
     *     
     */
    public WidgetMapType getWidgetMap() {
        return widgetMap;
    }

    /**
     * Sets the value of the widgetMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link WidgetMapType }
     *     
     */
    public void setWidgetMap(WidgetMapType value) {
        this.widgetMap = value;
    }

}