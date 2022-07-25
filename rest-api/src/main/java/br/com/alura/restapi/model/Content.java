package br.com.alura.restapi.model;

import org.springframework.data.annotation.Id;

public class Content {
        @Id
        private String id;
        private String title;
        private String imageUrl;
        
        public Content(String title, String imageUrl) {
            this.title = title;
            this.imageUrl = imageUrl;
        }
        public String getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
        public String getImageUrl() {
            return imageUrl;
        }
}
