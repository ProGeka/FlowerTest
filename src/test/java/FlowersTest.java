import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FlowersTest {
    @Test
    void successfulFlowersTest(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        //            Открываем интернет магазин
        open("https://semena-partner.ru");

        //            Выбираем Цветы в левом меню
        $(".flowers-icon").click();

        //            В фильтре выбираем Категория = Петунья
        $(".level2").click();

        //            Добавлям в корзину любую петунью
        $(".add-btn").click();

        //            Проверяем, что в верхнем правом окошке появилась 1 позиция
        $(".Bottom-header_num").shouldHave(text("1"));

        //            Открываем корзину
        $(".Bottom-header_basket").click();

        //            Удаляем через иконку мусорки
        $(".basket-item-actions-remove ").click();

        //            Проверяем информацию, что товар был удален и есть кнопка восстановить
        $(".basket-items-list-item-removed-container").shouldHave(text("Товар"));
        $(".basket-items-list-item-removed-container").shouldHave(text("был удален из корзины."));
        $(".basket-items-list-item-removed-container").shouldHave(text("Восстановить"));



    }
}
