public class Constants {
    public static final String STOP = "Стоп";
    public static final String START = "Старт";
    public static final String START_GAME = "Игра начинается";
    public static final String NUMBER_OF_TRY = "Колличество ошибок: ";
    public static final String ENTERED_LETTER = "Введите букву или слово целиком";
    public static final String WORD_SECRET = "Вам загадано слово: ";
    public static final String WELCOME = "Добро пожаловать в игру \"Виселица\"";
    public static final String START_PROMPT = "Если хотите начать новую игру введите '%s'  %nЕсли хотите выйти введите '%s'".formatted(START, STOP);
    public static final String THANKS = "Спасибо за игру";
    public static final String INVALID_INPUT = "Ввод не соответствует условию";
    public static final String YOU_WIN = "Вы угадали! Поздравляем";
    public static final String YOU_MISTAKE = "Вы ошиблись!";
    public static final String REPEAT_INPUT = "Вы уже вводили эту букву";
    public static final String TEMPLATE_LETTER_NOT = "Буквы: \"%s\" в слове нет.\n";
    public static final String ALREADY_USED = "Вы уже использовали: ";
    public static final String YOU_LOOSE = "Попытки закончились, вы проиграли! ";
    public static final String EASY_LEVEL = "Легкая";
    public static final String MEDIUM_LEVEL = "Средняя";
    public static final String HARD_LEVEL = "Трудная";

    public static final String SELECT_DIFFICULTY_TEMPLATE = "Выберете сложность игры: \n 1 - %s \n 2 - %s \n 3 - %s".formatted(EASY_LEVEL,MEDIUM_LEVEL,HARD_LEVEL);

    // Константы int

    public static final char MIN_NUMBER = '0';
    public static final char MAX_NUMBER = '9';

    public static final int MAX_TRY = 6;
    public static final int MIN_TRY = 0;




    private Constants(){}
}
