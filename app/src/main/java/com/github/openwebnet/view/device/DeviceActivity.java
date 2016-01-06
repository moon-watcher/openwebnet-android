package com.github.openwebnet.view.device;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.github.openwebnet.R;
import com.github.openwebnet.component.Injector;
import com.github.openwebnet.model.DeviceModel;
import com.github.openwebnet.model.RealmModel;
import com.github.openwebnet.service.DeviceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class DeviceActivity extends AbstractDeviceActivity {

    private static final Logger log = LoggerFactory.getLogger(DeviceActivity.class);

    @Inject
    DeviceService deviceService;

    @Bind(R.id.editTextDeviceName)
    EditText editTextDeviceName;

    @Bind(R.id.editTextDeviceRequest)
    EditText editTextDeviceRequest;

    @Bind(R.id.editTextDeviceResponse)
    EditText editTextDeviceResponse;

    @Bind(R.id.editTextDeviceMessageSuccess)
    EditText editTextDeviceMessageSuccess;

    @Bind(R.id.editTextDeviceMessageFail)
    EditText editTextDeviceMessageFail;

    @Bind(R.id.checkBoxDeviceRunOnLoad)
    CheckBox checkBoxDeviceRunOnLoad;

    @Bind(R.id.checkBoxDeviceConfirm)
    CheckBox checkBoxDeviceConfirm;

    @Bind(R.id.checkBoxDeviceAccept)
    CheckBox checkBoxDeviceAccept;

    @BindString(R.string.label_default_success)
    String labelDefaultSuccess;

    @BindString(R.string.label_default_fail)
    String labelDefaultFail;

    private String deviceUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Injector.getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        initSpinnerEnvironment();
        //selectEnvironment(); TODO current environment
        initSpinnerGateway();
        //selectGateway(); TODO default gateway
        initEditDevice();
    }

    private void initEditDevice() {
        deviceUuid = getIntent().getStringExtra(RealmModel.FIELD_UUID);
        log.debug("initEditDevice: {}", deviceUuid);
        if (deviceUuid != null) {
            // TODO edit
        }
    }

    @Override
    protected void onMenuSave() {
        log.debug("name: {}", editTextDeviceName.getText());
        log.debug("request: {}", editTextDeviceRequest.getText());
        log.debug("response: {}", editTextDeviceResponse.getText());
        log.debug("message-success: {}", editTextDeviceMessageSuccess.getText());
        log.debug("message-fail: {}", editTextDeviceMessageFail.getText());
        log.debug("environment: {}", getSelectedEnvironment());
        log.debug("gateway: {}", getSelectedGateway());
        log.debug("favourite: {}", isFavourite());
        log.debug("runOnLoad: {}", checkBoxDeviceRunOnLoad.isChecked());
        log.debug("confirm: {}", checkBoxDeviceConfirm.isChecked());
        log.debug("accept: {}", checkBoxDeviceAccept.isChecked());

        if (isValidDevice()) {
            if (deviceUuid == null) {
                deviceService.add(parseDevice()).subscribe(uuid -> finish());
            } else {
                deviceService.update(parseDevice())
                    .doOnCompleted(() -> finish())
                    .subscribe();
            }
        }
    }

    private boolean isValidDevice() {
        if (!checkBoxDeviceAccept.isChecked()) {
            checkBoxDeviceAccept.setError(validationRequired);
            checkBoxDeviceAccept.requestFocus();
        } else {
            checkBoxDeviceAccept.setError(null);
        }
        return checkBoxDeviceAccept.isChecked() &&
            isValidRequired(editTextDeviceName) &&
            isValidRequired(editTextDeviceRequest) &&
            isValidRequired(editTextDeviceResponse) &&
            isValidDeviceEnvironment() &&
            isValidDeviceGateway();
    }

    private DeviceModel parseDevice() {
        return (deviceUuid == null ? DeviceModel.addBuilder() : DeviceModel.updateBuilder(deviceUuid))
            .name(editTextDeviceName.getText().toString())
            .request(editTextDeviceRequest.getText().toString())
            .response(editTextDeviceResponse.getText().toString())
            .messageSuccess(getMessage(editTextDeviceMessageSuccess, labelDefaultSuccess))
            .messageFail(getMessage(editTextDeviceMessageFail, labelDefaultFail))
            .environment(getSelectedEnvironment().getId())
            .gateway(getSelectedGateway().getUuid())
            .favourite(isFavourite())
            .runOnLoad(checkBoxDeviceRunOnLoad.isChecked())
            .showConfirmation(checkBoxDeviceConfirm.isChecked())
            .build();
    }

    private String getMessage(TextView textView, String defaultMessage) {
        return TextUtils.isEmpty(textView.getText()) ? defaultMessage :
            textView.getText().toString();
    }

}
