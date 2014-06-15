
package net.bq;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for film complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="film">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filmUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="film_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hot_grade" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photo_link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poster_link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="runtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="showtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="view_link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "film", propOrder = {
    "description",
    "director",
    "filmUrl",
    "filmId",
    "hotGrade",
    "language",
    "name",
    "nickname",
    "photoLink",
    "posterLink",
    "rate",
    "runtime",
    "showtime",
    "viewLink"
})
public class Film {

    protected String description;
    protected String director;
    protected String filmUrl;
    @XmlElement(name = "film_id")
    protected int filmId;
    @XmlElement(name = "hot_grade")
    protected int hotGrade;
    protected String language;
    protected String name;
    protected String nickname;
    @XmlElement(name = "photo_link")
    protected String photoLink;
    @XmlElement(name = "poster_link")
    protected String posterLink;
    protected String rate;
    protected String runtime;
    protected String showtime;
    @XmlElement(name = "view_link")
    protected String viewLink;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the director property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the value of the director property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirector(String value) {
        this.director = value;
    }

    /**
     * Gets the value of the filmUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilmUrl() {
        return filmUrl;
    }

    /**
     * Sets the value of the filmUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilmUrl(String value) {
        this.filmUrl = value;
    }

    /**
     * Gets the value of the filmId property.
     * 
     */
    public int getFilmId() {
        return filmId;
    }

    /**
     * Sets the value of the filmId property.
     * 
     */
    public void setFilmId(int value) {
        this.filmId = value;
    }

    /**
     * Gets the value of the hotGrade property.
     * 
     */
    public int getHotGrade() {
        return hotGrade;
    }

    /**
     * Sets the value of the hotGrade property.
     * 
     */
    public void setHotGrade(int value) {
        this.hotGrade = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Gets the value of the photoLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoLink() {
        return photoLink;
    }

    /**
     * Sets the value of the photoLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoLink(String value) {
        this.photoLink = value;
    }

    /**
     * Gets the value of the posterLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosterLink() {
        return posterLink;
    }

    /**
     * Sets the value of the posterLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosterLink(String value) {
        this.posterLink = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuntime(String value) {
        this.runtime = value;
    }

    /**
     * Gets the value of the showtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowtime() {
        return showtime;
    }

    /**
     * Sets the value of the showtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowtime(String value) {
        this.showtime = value;
    }

    /**
     * Gets the value of the viewLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewLink() {
        return viewLink;
    }

    /**
     * Sets the value of the viewLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewLink(String value) {
        this.viewLink = value;
    }

}
