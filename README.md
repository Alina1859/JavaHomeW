# kvality-tests

UI-тесты kvality.io: Selenide + JUnit 5 + Allure.

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

    ./gradlew test                 # ENV=local (по умолчанию) — браузер открывается локально
    ./gradlew test -DENV=stage     # удалённо на selenoid, видео в отчёте
    ./gradlew test -DENV=prod      # тоже удалённо на selenoid

Остальные параметры (`baseUrl`, `remote`, `browser`, `browserVersion`, `headless`, `browserSize`) и отчёт Allure — как в основном проекте.
