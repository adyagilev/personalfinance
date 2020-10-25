package personalfinance.settings;

import java.util.Calendar;
import java.util.HashMap;

public final class Localization {
    private static HashMap<String, String> data = new HashMap();

    public static String get(String key) {
        if (data.containsKey(key)) return data.get(key);
        return key;
    }

    public static String[] getMonths() {
        return new String[] {
                data.get("MONTH_01"),
                data.get("MONTH_02"),
                data.get("MONTH_03"),
                data.get("MONTH_04"),
                data.get("MONTH_05"),
                data.get("MONTH_06"),
                data.get("MONTH_07"),
                data.get("MONTH_08"),
                data.get("MONTH_09"),
                data.get("MONTH_10"),
                data.get("MONTH_11"),
                data.get("MONTH_12"),
        };
    }

    public static void init() {
        data.put("PROGRAM_NAME", "Домашняя бухгалтерия");

        data.put("MENU_FILE", "Файл");
        data.put("MENU_EDIT", "Правка");
        data.put("MENU_VIEW", "Вид");
        data.put("MENU_HELP", "Помощь");
        data.put("MENU_FILE_NEW", "Новый");
        data.put("MENU_FILE_OPEN", "Открыть");
        data.put("MENU_FILE_SAVE", "Сохранить");
        data.put("MENU_FILE_EXIT", "Выход");
        data.put("MENU_FILE_UPDATE_CURRENCIES", "Обновить курсы валют");
        data.put("MENU_EDIT_ADD", "Добавить");
        data.put("MENU_EDIT_EDIT", "Редактировать");
        data.put("MENU_EDIT_DELETE", "Удалить");
        data.put("MENU_VIEW_OVERVIEW", "Обзор");
        data.put("MENU_VIEW_ACCOUNTS", "Счета");
        data.put("MENU_VIEW_ARTICLES", "Статьи");
        data.put("MENU_VIEW_TRANSACTIONS", "Операции");
        data.put("MENU_VIEW_TRANSFERS", "Переводы");
        data.put("MENU_VIEW_CURRENCIES", "Валюты");
        data.put("MENU_VIEW_STATISTIC", "Статистика");
        data.put("MENU_HELP_ABOUT", "О программе");

        data.put("TOOLBAR_OVERVIEW", "Обзор");
        data.put("TOOLBAR_ACCOUNTS", "Счета");
        data.put("TOOLBAR_ARTICLES", "Статьи");
        data.put("TOOLBAR_TRANSACTIONS", "Операции");
        data.put("TOOLBAR_TRANSFERS", "Переводы");
        data.put("TOOLBAR_CURRENCIES", "Валюты");
        data.put("TOOLBAR_STATISTIC", "Статистика");
        data.put("TOOLBAR_ADD", "Добавить");
        data.put("TOOLBAR_EDIT", "Редактировать");
        data.put("TOOLBAR_DELETE", "Удалить");

        data.put("INCOME_ACTIVE", "ДОХОДЫ Активные");
        data.put("INCOME_PASSIVE", "ДОХОДЫ Пассивные");
        data.put("OUTCOME_INVEST", "РАСХОДЫ Инвестиции");
        data.put("OUTCOME_SAVE", "РАСХОДЫ Накопления");
        data.put("OUTCOME_HELP", "РАСХОДЫ Благотворительность");
        data.put("OUTCOME_STUDY", "РАСХОДЫ Обучение");
        data.put("OUTCOME_FUN", "РАСХОДЫ Развлечения");
        data.put("OUTCOME_SPEND", "РАСХОДЫ Текущие");

        data.put("BALANCE_BY_ACCOUNTS", "Баланс по счетам");
        data.put("BALANCE_BY_CURRENCIES", "Баланс по валютам");
        data.put("BALANCE_TOTAL", "Общий капитал");

        data.put("TODAY", "Сегодня");
        data.put("YES", "Да");
        data.put("NO", "Нет");

        data.put("FC_HOME", "Домашняя директория");
        data.put("FC_OPEN", "Открыть");
        data.put("FC_SAVE", "Сохранить");
        data.put("FC_CANCEL", "Отмена");
        data.put("FC_LOOK", "Папка:");
        data.put("FC_NAME_FILE", "Имя файла:");
        data.put("FC_TYPE_FILE", "Тип файла:");
        data.put("FC_UP", "Вверх");
        data.put("FC_NEW_DIRECTORY", "Новая папка");
        data.put("FC_LIST", "Список");
        data.put("FC_TABLE", "Таблица");
        data.put("FC_NAME", "Имя");
        data.put("FC_SIZE", "Размер");
        data.put("FC_TYPE", "Тип");
        data.put("FC_DATE", "Дата");
        data.put("FC_ATTR", "Атрибуты");
        data.put("FC_ALL_FILTER", "Все файлы");

        data.put("MONTH_01", "Январь");
        data.put("MONTH_02", "Февраль");
        data.put("MONTH_03", "Март");
        data.put("MONTH_04", "Апрель");
        data.put("MONTH_05", "Май");
        data.put("MONTH_06", "Июнь");
        data.put("MONTH_07", "Июль");
        data.put("MONTH_08", "Август");
        data.put("MONTH_09", "Сентябрь");
        data.put("MONTH_10", "Октябрь");
        data.put("MONTH_11", "Ноябрь");
        data.put("MONTH_12", "Декабрь");

        data.put("ERROR", "Ошибка!");
        data.put("ERROR_NOT_EXISTS", "Запись не найдена");
        data.put("ERROR_ALREADY_EXISTS", "Запись уже существует");
        data.put("ERROR_EMPTY_TITLE", "Не указано название");
        data.put("ERROR_EMPTY_CURRENCY", "Валюта не указана");
        data.put("ERROR_EMPTY_PURPOSE", "Статья не указана");
        data.put("ERROR_EMPTY_ACCOUNT", "Счёт не указан");
        data.put("ERROR_EMPTY_CODE", "Код не указан");
        data.put("ERROR_EMPTY_DATE", "Не указана дата");
        data.put("ERROR_MESSAGE_IS_ABSENT", "Произошла неведомая ошибка");
        data.put("ERROR_AMOUNT_FORMAT", "Введены некорректные значения");
        data.put("ERROR_PRIMARY_CURRENCY_IS_NOT_SET", "Не выбрана базовая валюта. Для смены базовой валюты необходимо выставить соответствующий флаг у новой валюты.");

        data.put("BTN_LABEL_ADD", "Добавить");
        data.put("BTN_LABEL_CANCEL", "Отмена");
        data.put("BTN_LABEL_EDIT", "Изменить");
        data.put("BTN_LABEL_SAVE", "Сохранить");

        data.put("LABEL_ACCOUNT", "Счет");
        data.put("LABEL_ACCOUNT_FROM", "Счет списания");
        data.put("LABEL_ACCOUNT_TO", "Счет зачисления");
        data.put("LABEL_AMOUNT", "Сумма");
        data.put("LABEL_AMOUNT_FROM", "Сумма списания");
        data.put("LABEL_AMOUNT_TO", "Сумма зачисления");
        data.put("LABEL_CURRENCY", "Валюта");
        data.put("LABEL_DATE", "Дата");
        data.put("LABEL_DESCRIPTION", "Комментарий");
        data.put("LABEL_PURPOSE", "Статья");
        data.put("LABEL_PURPOSE_TYPE", "Тип");
        data.put("LABEL_START_AMOUNT", "Начальное значение");
        data.put("LABEL_TITLE", "Название");

        data.put("LABEL_CODE", "Код валюты");
        data.put("LABEL_RATE", "Курс к базовой валюте");
        data.put("LABEL_ACTIVE", "Активная");
        data.put("LABEL_PRIMARY", "Базовая");

        data.put("ADD_TITLE", "Добавление новой записи");
        data.put("EDIT_TITLE", "Редактирование записи");
        data.put("ABOUT_TITLE", "О программе");
        data.put("ABOUT_TEXT",
                "<body style='width:350px;font-size:110%;font-weight:normal;text-align:justify;'>" +
                "<h1 style='font-size:150%;font-weight:bold;text-align:center;'>Домашняя Бухгалтерия</h1>" +
                "<p style='text-align:center;'><img src='file:images/main.png' /></p>" +
                "<p>" +
                "Сайт рыбатекст поможет дизайнеру, верстальщику, вебмастеру сгенерировать несколько абзацев более менее осмысленного текста рыбы на русском языке, " +
                "а начинающему оратору отточить навык публичных выступлений в домашних условиях. При создании генератора мы использовали небезизвестный универсальный код речей. " +
                "Текст генерируется абзацами случайным образом от двух до десяти предложений в абзаце, что позволяет сделать текст более привлекательным и живым для визуально-слухового восприятия." +
                "<br>" +
                "По своей сути рыбатекст является альтернативой традиционному lorem ipsum, " +
                "который вызывает у некторых людей недоумение при попытках прочитать рыбу текст. " +
                "В отличии от lorem ipsum, текст рыба на русском языке наполнит любой макет непонятным смыслом " +
                "и придаст неповторимый колорит советских времен." +
                "</p>" +
                "<p><a style='color:#00f;' href='http://davphoto.ru'>davphoto.ru</a></p>" +
                "<p>С уважением, Андрей Дягилев</p>" +
                "<p style='text-align:center;'>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + "</p>" +
                "</body>"
        );
    }

}
