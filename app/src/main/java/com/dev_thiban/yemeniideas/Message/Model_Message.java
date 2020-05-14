package com.dev_thiban.yemeniideas.Message;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HIGH-TECH on 28/11/2018.
 */

public class Model_Message {

    @SerializedName("id")
    public int id;
    @SerializedName("is_admin")
    public int is_admin;
    @SerializedName("id_user_get")
    public int id_user_get;
    @SerializedName("id_user_post")
    public int id_user_post;
    @SerializedName("post_name")
    public String post_name;
    @SerializedName("post_img")
    public String post_img;
    @SerializedName("get_name")
    public String get_name;
    @SerializedName("get_img")
    public String get_img;
    @SerializedName("date")
    public String date;
    @SerializedName("number_message")
    public int number_message;
    @SerializedName("message")
    public String message;
    @SerializedName("type")
    public int type;


    // الرقم
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // اذا كانت رسالة ادارية او من مستخدم
    public int getIs_admin() {
        return is_admin;
    }
    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    // رقم المستقبل
    public int getId_user_get() {
        return id_user_get;
    }
    public void setId_user_get(int id_user_get) {
        this.id_user_get = id_user_get;
    }

    // رقم المرسل
    public int getId_user_post() {
        return id_user_post;
    }
    public void setId_user_post(int id_user_post) {
        this.id_user_post = id_user_post;
    }

    // اسم المرسل
    public String getPost_name() {
        return post_name;
    }
    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    // صورة المرسل
    public String getPost_img() {
        return post_img;
    }
    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    // اسم المستقبل
    public String getGet_name() {
        return get_name;
    }
    public void setGet_name(String get_name) {
        this.get_name = get_name;
    }

    // صورة المستقبل
    public String getGet_img() {
        return get_img;
    }
    public void setGet_img(String get_img) {
        this.get_img = get_img;
    }

    // التاريخ
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    // عدد الرسائل الغير مقروءة
    public int getNumber_message() {
        return number_message;
    }
    public void setNumber_message(int number_message) {
        this.number_message = number_message;
    }

    // الرسالة
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    // النوع
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
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
