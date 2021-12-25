package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.BaseModel;

import java.util.Objects;

public class Post extends BaseModel {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("userId")
    public Integer userId;

    @JsonProperty("title")
    public String title;

    @JsonProperty("body")
    public String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(userId, post.userId) && title.equals(post.title) && body.equals(post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, body);
    }
}
