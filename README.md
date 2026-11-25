# HH-Vacancy-tests

UI-тесты hh.ru: Selenide + JUnit 5 + Allure.

## Структура

```
src/test/java/
├── helpers/           — базовые хелперы (TestBase, Attach и т.д.)
├── models/            — POJO для тестовых данных
├── pages/             — Page Object'ы
│   └── components/    — переиспользуемые компоненты страниц
└── tests/             — тесты
```

## Запуск

    ./gradlew test

Параметры запуска и отчёт Allure — как в основном проекте (`baseUrl`, `remote`, `browser`, `browserVersion`, `headless`, `browserSize`).
