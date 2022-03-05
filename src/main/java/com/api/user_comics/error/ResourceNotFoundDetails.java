package com.api.user_comics.error;

public class ResourceNotFoundDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;

    private ResourceNotFoundDetails() {
    }


    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class ResourceNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private String developerMessage;

        private ResourceNotFoundDetailsBuilder() {
        }

        public static ResourceNotFoundDetailsBuilder newBuilder() {
            return new ResourceNotFoundDetailsBuilder();
        }

        public ResourceNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ResourceNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.status = this.status;
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.details = this.details;
            return resourceNotFoundDetails;
        }
    }
}
