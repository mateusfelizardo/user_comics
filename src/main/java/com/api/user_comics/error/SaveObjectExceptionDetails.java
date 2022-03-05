package com.api.user_comics.error;

public class SaveObjectExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;

    private SaveObjectExceptionDetails() {
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

    public static final class SaveObjectExceptionDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private String developerMessage;

        private SaveObjectExceptionDetailsBuilder() {
        }

        public static SaveObjectExceptionDetailsBuilder newBuilder() {
            return new SaveObjectExceptionDetailsBuilder();
        }

        public SaveObjectExceptionDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SaveObjectExceptionDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public SaveObjectExceptionDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public SaveObjectExceptionDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public SaveObjectExceptionDetails build() {
            SaveObjectExceptionDetails saveObjectExceptionDetails = new SaveObjectExceptionDetails();
            saveObjectExceptionDetails.title = this.title;
            saveObjectExceptionDetails.details = this.details;
            saveObjectExceptionDetails.developerMessage = this.developerMessage;
            saveObjectExceptionDetails.status = this.status;
            return saveObjectExceptionDetails;
        }
    }
}

