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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InitialMappingList" type="{}InitialMappingListType" minOccurs="0"/>
 *         &lt;element name="EdgeMappingList" type="{}EdgeMappingListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MappingType", propOrder = {
    "initialMappingList",
    "edgeMappingList"
})
public class MappingType {

    @XmlElement(name = "InitialMappingList")
    protected InitialMappingListType initialMappingList;
    @XmlElement(name = "EdgeMappingList")
    protected EdgeMappingListType edgeMappingList;

    /**
     * Gets the value of the initialMappingList property.
     * 
     * @return
     *     possible object is
     *     {@link InitialMappingListType }
     *     
     */
    public InitialMappingListType getInitialMappingList() {
        return initialMappingList;
    }

    /**
     * Sets the value of the initialMappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialMappingListType }
     *     
     */
    public void setInitialMappingList(InitialMappingListType value) {
        this.initialMappingList = value;
    }

    /**
     * Gets the value of the edgeMappingList property.
     * 
     * @return
     *     possible object is
     *     {@link EdgeMappingListType }
     *     
     */
    public EdgeMappingListType getEdgeMappingList() {
        return edgeMappingList;
    }

    /**
     * Sets the value of the edgeMappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EdgeMappingListType }
     *     
     */
    public void setEdgeMappingList(EdgeMappingListType value) {
        this.edgeMappingList = value;
    }

}
