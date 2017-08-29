package de.hpi.data_change.imdb.data;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Property;

import java.util.Arrays;
import java.util.List;

public class Rating implements CustomEntity {

    private String new_;
    private String distribution;
    private int votes;
    private float rank;
    private String title;

    public Rating(String new_, String distribution, int votes, float rank, String title) {
        this.new_ = new_;
        this.distribution = distribution;
        this.votes = votes;
        this.rank = rank;
        this.title = title;
    }

    public String getNew_() {
        return new_;
    }

    public void setNew_(String new_) {
        this.new_ = new_;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Entity toEntity() {
        List<Property> properties = buildProperties();
        Entity entity = new Entity(title,properties);
        return entity;
    }

    private List<Property> buildProperties() {
        return Arrays.asList(new Property("new",new_),
                new Property("RatingDistribution",distribution),
                new Property("VotesInRating",votes+""),
                new Property("RatingRank",rank+"")
        );
    }
}
