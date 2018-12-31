
package com.example.hmspl.yearbookapp.modules.dtos;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "categories"
})
public class CategoryListResponse implements Serializable, Parcelable
{

    @JsonProperty("categories")
    private List<Category> categories = null;
    public final static Creator<CategoryListResponse> CREATOR = new Creator<CategoryListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CategoryListResponse createFromParcel(Parcel in) {
            return new CategoryListResponse(in);
        }

        public CategoryListResponse[] newArray(int size) {
            return (new CategoryListResponse[size]);
        }

    }
    ;
    //private final static long serialVersionUID = -4118530399981962478L;

    protected CategoryListResponse(Parcel in) {
        in.readList(this.categories, (Category.class.getClassLoader()));
    }

    public CategoryListResponse() {
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(categories);
    }

    public int describeContents() {
        return  0;
    }

}
