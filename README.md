Приложение «Продовольственная корзина»

Необходимо написать приложение пользования интернет – магазином и совершения покупок.

Приложение запускается со стартового экрана, который содержит картинку магазина, название и кнопку начала покупок. Все элементы анимированы на свой выбор. По нажатию на кнопку «Начать покупки» выполняется переход на следующий экран (активити, либо фрагмент), на котором расположен список товаров магазина.

Элемент списка содержит: картинку(фото) товара, название и цену.

По нажатию на элемент списка появляется диалоговое окно, в котором есть кнопка «В корзину» и «Отмена». По нажатию на кнопку «В корзину», купленный продукт помещается в список купленных товаров, его на этом экране не видно. По нажатию на кнопку «Отмена», покупка не производится.

Кроме того, на этом экране есть кнопка floatingActionButton, по нажатию на которую выполняется переход на третий экран – экран товаров, находящихся в корзине. Все товары корзины располагаются в списке. Элемент списка содержит выше описанные позиции. По нажатию на элемент списка, появляется диалоговое окно, в котором есть кнопка «Удалить из корзины» и «Отмена». В случае удаления товара, из списка корзины он пропадает.

На этом же экране есть кнопка floatingActionButton, по нажатию на которую выполняется переход на четвертый экран – экран чека купленных товаров. Это поле вывода должно содержать информацию о купленных Вами товарах, форма чека составляется приблизительная, на свой выбор.

Выход из приложения выполняется по нажатию на пункт меню «Exit».

Реализацию всех списков необходимо выполнить на основе RecyclerView со всеми соответствующими элементами (элемент списка, адаптер). Реализацию диалоговых окон для работы с элементом списка выполнить на основе AlertDialog.

Приветствуется анимирование элементов приложения.

Для работы приложения необходимо создать:

На первом экране:

1. Поле вывода названия магазина.

2. ImageView – картинка магазина

3. Кнопка «Начать покупки».

На втором экране:

1. Toolbar с заголовком названия магазина

2. RecyclerView для отображения списка товаров.

3. FloatingActionButton для перехода в корзину.

4. Пункт меню «Exit» для выхода из приложения.

На третьем экране:

1. Toolbar с заголовком названия магазина

2. RecyclerView для отображения списка товаров корзины.

3. FloatingActionButton для перехода к чеку купленных товаров.

4. Пункт меню «Exit» для выхода из приложения.

На четвертом экране:

1. Toolbar с заголовком названия магазина

2. Поле вывода чека товаров.

3. Пункт меню «Exit» для выхода из приложения.

[Video](https://rutube.ru/video/private/60353ecfe09899c877e74d0d60e0bc67/?p=g_igcZRG2F_06equ2nenqQ)