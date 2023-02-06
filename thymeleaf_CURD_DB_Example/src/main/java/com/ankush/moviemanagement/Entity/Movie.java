package com.ankush.moviemanagement.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movie_id;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "movie_duration")
	private long movieDuration;
	
	@Column(name = "movie_language")
	private String movieLanguage;  // [hindi, tamil, ..]
	
	@Column(name = "release_date")
	private Timestamp releaseDate;
	
	@Column(name = "movie_trailer")
	private String movieTrailer;
	
	@Column(name = "movie_type")
	private String movieType;    // Adv , action
	
	@Column(name = "movie_description")
	private String movieDescription; 
	
	@Column(name = "movie_lead_actor")
	private String movieLeadActor;

	@Column(name = "movie_lead_actress")
	private String movieLeadActress;
	
	@Column(name = "movie_directed_by")
	private String movieDirectedBy;
	
	@Column(name = "movie_production_company")
	private String movieProductionCompany;
	
	@Column(name = "movie_imbd_rating")
	private long movieIMDBRating;
	
	
	@Column(name = "movie_background_img")
	private String movieBackgroundImg;
	
	@Column(name = "movie_gallery_img")
	private String movieGalleryImg;  // put the data into set[] , , , 
	
}
	