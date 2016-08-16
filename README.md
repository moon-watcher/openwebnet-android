# openwebnet-android ![openwebnet-android](images/logo.png)

[![Build Status](https://travis-ci.org/openwebnet/openwebnet-android.svg)](https://travis-ci.org/openwebnet/openwebnet-android)
[![Coverage Status](https://coveralls.io/repos/github/openwebnet/openwebnet-android/badge.svg?branch=master)](https://coveralls.io/github/openwebnet/openwebnet-android?branch=master)

> work in progress!

OpenWebNet Android client for My Home [BTicino](http://www.bticino.it/domotica-casa-connessa) and [Legrand](http://www.myopen-legrandgroup.com/) home automation system

My Home is the BTicino and Legrand home domotic system that let you manage your house from smartphones through [OpenWebNet](https://en.wikipedia.org/wiki/OpenWebNet) protocol.

Manages:
- Lighting
- Automation
- Temperature
- any OpenWebNet frame/message
- Ip Camera (MJPEG)

Handle multiple gateway simultaneously with IP or Domain and password.

It isn't mandatory, but it's highly recommended that you access your domotic system using a VPN connection.

Database encrypted to increase security.

This Android application is an unofficial free and Open Source client under MIT license.

If you like this app and find it useful please consider making a donation. Some possible future improvements:
- Sound System / Radio
- Energy Management
- Quick search and sorting
- Backup / Import / Export configuration

If you find a bug or have any suggestions do not leave a negative rating but contact me via email, I will try to help you.

*OpenWebNet is a BTicino registered trademark*

### Screenshots

<img src="images/en/screenshot-menu.png" alt="menu" height="600" />
<img src="images/en/screenshot-bs.png" alt="bs" height="600" />

<img src="images/en/screenshot-environment-fab.png" alt="environment-fab" height="600" />
<img src="images/en/screenshot-device-debug.png" alt="device-debug" height="600" />

<img src="images/en/screenshot-ipcam.png" alt="ipcam" height="600" />
<img src="images/en/screenshot-add-edit-device.png" alt="add-edit-device" height="600" />

<a href="https://play.google.com/store/apps/details?id=com.github.openwebnet&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-AC-global-none-all-co-pr-py-PartBadges-Oct1515-1"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/apps/en-play-badge.png" width="200"/></a>

### Changelog

#### v2.6.2 (August 16, 2016)

- Fix donation

#### v2.6.1 (August 16, 2016)

- Add donation feature

#### v2.6.0 (August 11, 2016)

- Add billing permission

#### v2.5.1 (August 6, 2016)

- Fix error gateway with password

#### v2.5.0 (July 28, 2016)

- Add support for gateway with password and domain

#### v2.4.2 (June 13, 2016)

- Minor fix

#### v2.4.1 (June 11, 2016)

- Change Temperature Scale in settings
- Minor style changes

#### v2.4.0 (June 8, 2016)

- Add Temperature features

#### v2.3.1 (May 14, 2016)

- Minor fix

#### v2.3.0 (May 5, 2016)

- Add Ip Camera features

#### v2.2.0 (April 28, 2016)

- Encrypted database

#### v2.1.1 (April 23, 2016)

- Update Russian language support

#### v2.1.0 (April 19, 2016)

- Add Russian language support

#### v2.0.0 (March 20, 2016)

- New menu
- Bug fix
- Minor style changes

#### v1.4.2 (March 9, 2016)

- Fix error on android 4.1
- Delete environments
- Minor style changes

#### v1.4.1 (March 3, 2016)

- Minor style changes

#### v1.4.0 (March 2, 2016)

- Add automation features
- Minor style changes

#### v1.3.0 (February 24, 2016)

- Add French language support

#### v1.2.0 (February 10, 2016)

- Handle columns on orientation change
- Add Italian language support

#### v1.1.0 (February 8, 2016)

- Add device debug

#### v1.0.0 and previous releases (January 29, 2016)

- Add/edit environments
- Add gateways
- Show favourites
- Add light features
- Add device features

### Other contributors
- [Nicolas Moreau](https://github.com/moreau-nicolas)
- [terranum](https://github.com/terranum)

Thanks to:

* [Dagger 2](http://google.github.io/dagger)
* [Butter Knife](http://jakewharton.github.io/butterknife)
* ~~[Lombok](https://projectlombok.org)~~
* [Retrolambda](https://github.com/orfjackal/retrolambda)
* [Lightweight-Stream-API](https://github.com/aNNiMON/Lightweight-Stream-API)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [Realm](https://realm.io)
* [EventBus](https://github.com/greenrobot/EventBus)
* [ThreeTen](https://github.com/ThreeTen/threetenbp)
* [slf4j + android-logger](http://noveogroup.github.io/android-logger)
* [Robolectric](http://robolectric.org/)
* [mockito](http://mockito.org/)
* [PowerMock](https://github.com/jayway/powermock)
