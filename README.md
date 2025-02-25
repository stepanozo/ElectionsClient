Клиентское приложение для выборов, написанное с использованием фрейморков Spring, Swing.

Для его работы необходимо запущенное на компьютере серверное приложение: https://github.com/stepanozo/ElectionsServer
Клиентское приложение собирается и запускается в среде IDE Netbeans.

В системе изначально присутствует один админ:

login: admin

password: admin

Можно наделить полномочиями админа другого пользователя, указав его логин, либо же отобрать полномочия.
Пароль должен состоять из латинских букв, цифр и подчеркиваний и быть не короче 5 символов. Логин - тоже

Файлы кандидатов должны иметь расширение .txt и иметь следующий формат:

ФИО кандидата

Год рождения (в виде числа)

Город проживания

Партия

Доп. информация

Кандидаты с выборов 2024 уже лежат в папке textFiles, так что можно указывать путь на неё.

Пример:

Владимир Владимирович Путин

1952

Москва

Самовыдвижение

Президент Российской Федерации

При запуске новых выборов информация о предыдущих будет выгружаться в папку Save, в файлы с названиями Elections *номер выборов*
