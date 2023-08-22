# SpringShopDemo

front <--> backend <--> DB (PostgresQL)

tech:
1. boot
2. web
3. security
4. thymeleaf
5. data jpa + posgresQL
6. flyway
7. lombok

небольшой скелетик тз:
1. Регистрация и аутентификация пользователя
2. Защита приложения
3. Просмотр товаров
4. Добавление товаров в корзину
5. Формирование заказов
6. Оплата (пока что онли PayPal, позже добавлю Сбер, Тинькофф,
            Google Pay и мб еще пару банков)
7. Фильтрация и сортировка товаров
8. Управление корзиной
9. Валидация вводимых данных
10. Оповещения по e-mail
11. Навигация

Entyties (сущности, объекты, модели)

1. Продукт (Product):
    - id
    - title
    - price
    - categories
    - nds, sales (optional)

2. Пользователь (User):
    - id
    - username
    - password
    - e-mail
    - role
    - address (optional)
    - archive
    - phone

3. Роль (Role) - пусть будет Enum:
    - USER
    - GUEST
    - ADMIN
    - MANAGER

4. Заказ (Order):
    - id
    - created date
    - last change date
    - completed date
    - adress
    - user
    - status (NEW, CANCEL, PAID, CLOSED, RETURNED)
    - details (product, pricem amount, comment)

5. Категория (Category):
    - id
    - title

6. Корзина
    - id
    - user
    - details (product, amount / product list)
