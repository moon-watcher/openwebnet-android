package com.github.openwebnet.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

import static java.util.Objects.requireNonNull;

public class DeviceModel extends RealmObject implements RealmModel, DomoticModel {

    public static final String FIELD_ENVIRONMENT_ID = "environmentId";

    public enum Status {
        SUCCESS, FAIL
    }

    @PrimaryKey
    private String uuid;

    @Required
    private Integer environmentId;

    @Required
    private String gatewayUuid;

    @Required
    private String name;

    @Required
    private String request;

    @Required
    private String response;

    private String messageSuccess;

    private String messageFail;

    private boolean favourite;

    private boolean runOnLoad;

    private boolean showConfirmation;

    @Ignore
    private Status status;

    public DeviceModel() {}

    public DeviceModel(Builder builder) {
        this.uuid = builder.uuid;
        this.environmentId = builder.environmentId;
        this.gatewayUuid = builder.gatewayUuid;
        this.name = builder.name;
        this.request = builder.request;
        this.response = builder.response;
        this.messageSuccess = builder.messageSuccess;
        this.messageFail = builder.messageFail;
        this.favourite = builder.favourite;
        this.runOnLoad = builder.runOnLoad;
        this.showConfirmation = builder.showConfirmation;
    }

    public static class Builder {

        private final String uuid;
        private Integer environmentId;
        private String gatewayUuid;
        private String name;
        private String request;
        private String response;
        private String messageSuccess;
        private String messageFail;
        private boolean favourite;
        private boolean runOnLoad;
        private boolean showConfirmation;

        public Builder(String uuid) {
            this.uuid = uuid;
        }

        public Builder environment(Integer environmentId) {
            this.environmentId = environmentId;
            return this;
        }

        public Builder gateway(String gatewayUuid) {
            this.gatewayUuid = gatewayUuid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder request(String request) {
            this.request = request;
            return this;
        }

        public Builder response(String response) {
            this.response = response;
            return this;
        }

        public Builder messageSuccess(String message) {
            this.messageSuccess = message;
            return this;
        }

        public Builder messageFail(String message) {
            this.messageFail = message;
            return this;
        }

        public Builder favourite(boolean favourite) {
            this.favourite = favourite;
            return this;
        }

        public Builder runOnLoad(boolean value) {
            this.runOnLoad = value;
            return this;
        }

        public Builder showConfirmation(boolean value) {
            this.showConfirmation = value;
            return this;
        }

        public DeviceModel build() {
            requireNonNull(environmentId, "environmentId is null");
            requireNonNull(gatewayUuid, "gatewayUuid is null");
            requireNonNull(name, "name is null");
            requireNonNull(request, "request is null");
            requireNonNull(response, "response is null");

            return new DeviceModel(this);
        }
    }

    public static Builder addBuilder() {
        return new Builder(UUID.randomUUID().toString());
    }

    public static Builder updateBuilder(String uuid) {
        return new Builder(uuid);
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }

    public String getGatewayUuid() {
        return gatewayUuid;
    }

    public void setGatewayUuid(String gatewayUuid) {
        this.gatewayUuid = gatewayUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessageSuccess() {
        return messageSuccess;
    }

    public void setMessageSuccess(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }

    public String getMessageFail() {
        return messageFail;
    }

    public void setMessageFail(String messageFail) {
        this.messageFail = messageFail;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public boolean isRunOnLoad() {
        return runOnLoad;
    }

    public void setRunOnLoad(boolean runOnLoad) {
        this.runOnLoad = runOnLoad;
    }

    public boolean isShowConfirmation() {
        return showConfirmation;
    }

    public void setShowConfirmation(boolean showConfirmation) {
        this.showConfirmation = showConfirmation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
