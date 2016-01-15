package com.github.openwebnet.component;

import com.github.openwebnet.OpenWebNetApplication;
import com.github.openwebnet.component.module.ApplicationContextModule;
import com.github.openwebnet.component.module.DomoticModule;
import com.github.openwebnet.component.module.RepositoryModule;
import com.github.openwebnet.repository.DatabaseHelper;
import com.github.openwebnet.repository.impl.CommonRealmRepositoryImpl;
import com.github.openwebnet.repository.impl.DeviceRepositoryImpl;
import com.github.openwebnet.repository.impl.EnvironmentRepositoryImpl;
import com.github.openwebnet.repository.impl.LightRepositoryImpl;
import com.github.openwebnet.service.impl.CommonServiceImpl;
import com.github.openwebnet.service.impl.DeviceServiceImpl;
import com.github.openwebnet.service.impl.EnvironmentServiceImpl;
import com.github.openwebnet.service.impl.GatewayServiceImpl;
import com.github.openwebnet.service.impl.LightServiceImpl;
import com.github.openwebnet.service.impl.PreferenceServiceImpl;
import com.github.openwebnet.view.MainActivity;
import com.github.openwebnet.view.NavigationItemListener;
import com.github.openwebnet.view.device.DeviceActivity;
import com.github.openwebnet.view.device.DeviceListAdapter;
import com.github.openwebnet.view.device.DeviceListFragment;
import com.github.openwebnet.view.device.LightActivity;
import com.github.openwebnet.view.settings.GatewayEditTextPreference;
import com.github.openwebnet.view.settings.GatewayListPreference;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationContextModule.class, DomoticModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    // view
    void inject(OpenWebNetApplication application);
    void inject(MainActivity activity);
    void inject(DeviceActivity activity);
    void inject(LightActivity activity);
    void inject(DeviceListFragment fragment);

    void inject(NavigationItemListener listener);
    void inject(GatewayEditTextPreference editTextPreference);
    void inject(GatewayListPreference listPreference);
    void inject(DeviceListAdapter deviceListAdapter);

    // service
    void inject(CommonServiceImpl commonService);
    void inject(DeviceServiceImpl deviceService);
    void inject(EnvironmentServiceImpl environmentService);
    void inject(GatewayServiceImpl gatewayService);
    void inject(LightServiceImpl lightService);
    void inject(PreferenceServiceImpl preferenceService);

    // repository
    void inject(DatabaseHelper databaseHelper);
    void inject(CommonRealmRepositoryImpl repository);
    void inject(DeviceRepositoryImpl repository);
    void inject(EnvironmentRepositoryImpl repository);
    void inject(LightRepositoryImpl repository);

}
