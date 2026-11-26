# Проект по автоматизации тестирования для сервиса Kvality

> Kvality — AI-квалификация лидов без CRM прямо в Telegram: AI анализирует заявки, менеджер подтверждает качество лида в Telegram, а Kvality передаёт вердикты и результаты квалификации в Яндекс Метрику для обучения рекламы.

## Содержание:

---

- [Технологии и инструменты](#технологии-и-инструменты)
- [Примеры автоматизированных тест-кейсов](#примеры-автоматизированных-тест-кейсов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Запуск из терминала](#запуск-из-терминала)
- [Allure отчет](#allure-отчет)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомление в Telegram при помощи бота](#уведомление-в-telegram-при-помощи-бота)
- [Примеры видео выполнения тестов на Selenoid](#примеры-видео-выполнения-тестов-на-selenoid)

---

## Технологии и инструменты:

<img src="images/logo/Intelij_IDEA.svg" width="40" height="40" alt="IDEA"/>
<img src="images/logo/Java.svg" width="40" height="40" alt="Java"/>
<img src="images/logo/Github.svg" width="40" height="40" alt="GitHub"/>
<img src="images/logo/JUnit5.svg" width="40" height="40" alt="JUnit 5"/>
<img src="images/logo/Gradle.svg" width="40" height="40" alt="Gradle"/>
<img src="images/logo/Selenide.svg" width="40" height="40" alt="Selenide"/>
<img src="images/logo/Selenoid.svg" width="40" height="40" alt="Selenoid"/>
<img src="images/logo/Allure.svg" width="40" height="40" alt="Allure"/>
<img src="images/logo/Allure2.svg" width="40" height="40" alt="Allure TestOps"/>
<img src="images/logo/Jenkins.svg" width="40" height="40" alt="Jenkins"/>
<img src="images/logo/Jira.svg" width="40" height="40" alt="Jira"/>

---

## Примеры автоматизированных тест-кейсов:

---

- ✓ _Поиск заявки по телефону из списка_
- ✓ _Поиск по несуществующему значению показывает заглушку «Заявки не найдены»_
- ✓ _Клик по посетителю в списке открывает его карточку_
- ✓ _Фильтр «Устройство: Компьютер» оставляет в списке только посетителей с компьютера_

---

## Сборка в Jenkins

---

![Сборка в Jenkins](images/screen/jenkins_build.png)

### Параметры сборки в Jenkins:

- _ENV (окружение: local, stage или prod, по умолчанию local)_
- _browser (браузер, по умолчанию chrome)_
- _browserVersion (версия браузера, по умолчанию 157.0)_
- _browserSize (размер окна браузера, по умолчанию 1920x1080)_
- _headless (без открытия браузера, по умолчанию false)_
- _baseUrl (адрес тестируемого веб-сайта, по умолчанию https://kvality.io)_
- _remote (логин, пароль и адрес удаленного сервера Selenoid)_

## Запуск из терминала

---

___Локальный запуск:___

```
./gradlew clean test
```

___Удалённый запуск через Jenkins:___

```
clean test
"-DENV=${ENV}"
"-Dbrowser=${browser}"
"-DbrowserVersion=${browserVersion}"
"-DbrowserSize=${browserSize}"
"-Dheadless=${headless}"
"-DbaseUrl=${baseUrl}"
"-Dremote=${remote}"
```

---

## Allure отчет

---

[Отчёт последней сборки в Jenkins](https://jenkins.qa.guru/view/java_students/job/kvality-tests/allure/)

### Основная страница отчёта

![Allure Overview](images/screen/allure_overview.png)

### Тест-кейсы

![Allure Tests](images/screen/allure_tests.png)

### Графики

![Allure Graphs: Status, Severity](images/screen/allure_graphs_status.png)
![Allure Graphs: Duration, Duration trend](images/screen/allure_graphs_duration.png)
![Allure Graphs: Retries trend, Categories trend](images/screen/allure_graphs_trends.png)

---

## Интеграция с Allure TestOps

---

[Запуск тестов в Allure TestOps](https://allure.qa.guru/launch/57520)

### Allure TestOps Dashboard

![Allure TestOps Dashboard](images/screen/testops_dashboard.png)

### Ручные тест-кейсы

![Manual tests](images/screen/testops_manual.png)

### Авто тест-кейсы

![Auto tests](images/screen/testops_auto.png)

---

## Интеграция с Jira

---

![Jira](images/screen/jira.png)

---

## Уведомление в Telegram при помощи бота

---

![Telegram](images/screen/telegram.png)

---

## Примеры видео выполнения тестов на Selenoid

---

![Selenoid Video](images/video/selenoid.gif)
