package kitchenpos.menu.exceptions;

public enum InputMenuDataErrorCode {

    IT_CAN_NOT_INPUT_MENU_PRICE_LESS_THAN_ZERO("[ERROR]메뉴 가격은 0보다 작을 수 없습니다"),
    YOU_MUST_INPUT_MENU_GROUP_ID("[ERROR] 메뉴 그룹 아이디는 필수 입력입니다."),
    THE_MENU_GROUP_ID_IS_LESS_THAN_ZERO("[ERROR] 메뉴 그룹 아이디는 0미만일수 없습니다."),
    THE_PRODUCT_IS_NOT_REGISTERED("[ERROR] 상품이 등록되지 않았습니다.");

    private String errorMessage;

    InputMenuDataErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage(){
        return this.errorMessage;
    }
}
