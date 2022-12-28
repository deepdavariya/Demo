package com.Manish.JobPost.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")

public class post {
    private String profile;
    private String desc;
    private String techs[];
    private int exp;

    public post() {
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getTechs() {
        return techs;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "post [profile=" + profile + ", desc=" + desc + ", techs=" + Arrays.toString(techs) + ", exp=" + exp
                + "]";
    }

}
