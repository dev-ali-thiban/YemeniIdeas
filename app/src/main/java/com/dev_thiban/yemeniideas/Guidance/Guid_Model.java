package com.dev_thiban.yemeniideas.Guidance;

import com.google.gson.annotations.SerializedName;

public class Guid_Model {

        @SerializedName("id")
        public int id;
        @SerializedName("title")
        public String title;
        @SerializedName("body")
        public String body;
        @SerializedName("type")
        public int type;
        @SerializedName("img")
        public int img;
        @SerializedName("link")
        public String link;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getBody() {
                return body;
        }

        public void setBody(String body) {
                this.body = body;
        }

        public int getType() {
                return type;
        }

        public void setType(int type) {
                this.type = type;
        }

        public int getImg() {
                return img;
        }

        public void setImg(int img) {
                this.img = img;
        }

        public String getLink() {
                return link;
        }

        public void setLink(String link) {
                this.link = link;
        }

        // الكود الخاص بالادبتر
        @SerializedName("viewType")
        private int viewType;
        ////
        public int getViewType() {
            return viewType;
        }
        public void setViewType(int viewType) {
            this.viewType = viewType;
        }
        ////



}
