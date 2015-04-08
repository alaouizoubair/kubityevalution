package com.kubity.evaluation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Cache
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {

    @Id
    private Long id;

    private int publicationYear;

    @Load
    private Ref<Author> authorRef;

    private String title;

	private String thumbnailURL;

    public Book() {
    }

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

	@JsonGetter("author")
    public Ref<Author> getAuthorRef() {
        return authorRef;
    }

    public void setAuthorRef(Ref<Author> authorRef) {
        this.authorRef = authorRef;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
