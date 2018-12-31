
package com.example.hmspl.yearbookapp.modules.dtos;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isUsed",
    "_id",
    "name",
    "createdBy",
    "updatedBy",
    "createdDate",
    "updatedDate",
    "__v"
})
public class Category implements Serializable, Parcelable
{

    @JsonProperty("isUsed")
    private Boolean isUsed;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("updatedDate")
    private String updatedDate;
    @JsonProperty("__v")
    private Integer v;
    public final static Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5086797703483162757L;

    protected Category(Parcel in) {
        this.isUsed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.createdDate = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Category() {
    }

    @JsonProperty("isUsed")
    public Boolean getIsUsed() {
        return isUsed;
    }

    @JsonProperty("isUsed")
    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updatedBy")
    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updatedBy")
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("updatedDate")
    public String getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updatedDate")
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonProperty("__v")
    public Integer getV() {
        return v;
    }

    @JsonProperty("__v")
    public void setV(Integer v) {
        this.v = v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isUsed);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(createdBy);
        dest.writeValue(updatedBy);
        dest.writeValue(createdDate);
        dest.writeValue(updatedDate);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}
