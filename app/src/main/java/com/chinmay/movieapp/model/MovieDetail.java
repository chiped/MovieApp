package com.chinmay.movieapp.model;

import com.chinmay.movieapp.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ChiP on 3/26/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetail {

    private int id;
    private String imdbId;
    private String originalTitle;
    private String title;
    private String overview;
    private String tagline;
    private double voteAverage;
    private long voteCount;
    private double runtime;
    private Date releaseDate;
    private List<GenericClassWithNameField> genreResponseList;
    private List<String> genres;
    private List<GenericClassWithNameField> languageResponseList;
    private List<String> languages;
    private List<GenericClassWithNameField> countriesResponseList;
    private List<String> countries;
    private List<GenericClassWithNameField> productionCompaniesResponseList;
    private List<String> productionCompanies;
    private double budget;
    private double revenue;
    private String backdropPath;
    private String posterPath;
    private boolean video;

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdb_id")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("genres")
    public void setGenreResponseList(List<GenericClassWithNameField> genreResponseList) {
        this.genreResponseList = genreResponseList;
    }

    public List<String> getGenres() {
        if(genres == null && !Utils.isEmptyOrNull(genreResponseList)) {
            genres = new ArrayList<>();
            for(GenericClassWithNameField genre : genreResponseList) {
                genres.add(genre.name);
            }
        }
        return genres;
    }

    @JsonProperty("spoken_languages")
    public void setLanguageResponseList(List<GenericClassWithNameField> languageResponseList) {
        this.languageResponseList = languageResponseList;
    }

    public List<String> getLanguages() {
        if(languages == null && !Utils.isEmptyOrNull(languageResponseList)) {
            languages = new ArrayList<>();
            for(GenericClassWithNameField language : languageResponseList) {
                languages.add(language.name);
            }
        }
        return languages;
    }

    @JsonProperty("production_countries")
    public void setCountriesResponseList(List<GenericClassWithNameField> countriesResponseList) {
        this.countriesResponseList = countriesResponseList;
    }

    public List<String> getCountries() {
        if(countries == null && !Utils.isEmptyOrNull(countriesResponseList)) {
            countries = new ArrayList<>();
            for(GenericClassWithNameField country : countriesResponseList) {
                countries.add(country.name);
            }
        }
        return countries;
    }

    @JsonProperty("production_companies")
    public void setProductionCompaniesResponseList(List<GenericClassWithNameField> productionCompaniesResponseList) {
        this.productionCompaniesResponseList = productionCompaniesResponseList;
    }

    public List<String> getProductionCompanies() {
        if(productionCompanies == null && !Utils.isEmptyOrNull(productionCompaniesResponseList)) {
            productionCompanies = new ArrayList<>();
            for(GenericClassWithNameField productionCompany : productionCompaniesResponseList) {
                productionCompanies.add(productionCompany.name);
            }
        }
        return productionCompanies;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
