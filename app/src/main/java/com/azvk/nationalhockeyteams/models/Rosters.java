package com.azvk.nationalhockeyteams.models;

public class Rosters{

        private String name;
        private String team;
        private String position;
        private String birthdate;
        private String birthplace;
        private int number;
        private int weight;
        private int height;
        private String imageUrl;
        private String national_team;

        public Rosters(){}

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}