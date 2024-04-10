package com.gourianova.acoustic.action;

import com.gourianova.acoustic.action.admin.GotoAdminPageAction;
import com.gourianova.acoustic.action.admin.ShowAdminPageAction;
import com.gourianova.acoustic.action.admin.role.AddRoleAction;
import com.gourianova.acoustic.action.admin.role.DeleteRoleAction;
import com.gourianova.acoustic.action.admin.item.*;
import com.gourianova.acoustic.action.admin.user.*;
import com.gourianova.acoustic.action.admin.user.*;
import com.gourianova.acoustic.action.locale.ChangeLocaleAction;
import com.gourianova.acoustic.action.item.ShowAllItemsByPageAction;
import com.gourianova.acoustic.action.item.*;
import com.gourianova.acoustic.action.user.LoginUserAction;
import com.gourianova.acoustic.action.user.LogoutUserAction;
import com.gourianova.acoustic.action.user.RegisterUserAction;
import com.gourianova.acoustic.action.admin.item.*;
import com.gourianova.acoustic.action.item.*;


public enum ActionType {
    LOGIN(new LoginUserAction()),
    LOGOUT(new LogoutUserAction()),
    REGISTER(new RegisterUserAction()),
    CHANGE_LOCALE(new ChangeLocaleAction()),
    ADD_ROLE(new AddRoleAction()),

    ADD_ITEM(new AddItemAction()),
    ADD_CONSTRUCT(new AddConstructAction()),

    ADD_CONSTRUCTION(new AddConstructionAction()),
    ADD_MATERIAL(new AddMaterialAction()),

    EDIT_ITEM(new EditItemAction()),

    CHANGE_USER_ROLE(new ChangeUserRoleAction()),
    CHANGE_USER_DATA(new ChangeUserDataAction()),


  SHOW_ALL_USER_ITEMS(new ShowAllUserItemsAction()),

    SHOW_ALL_USER_ITEMS_CHANGING(new ShowAllItemsByPageAction()),

    SHOW_ALL_ITEMS(new ShowAllItemsAction()),
    SHOW_ALL_CONSTRUCTS(new ShowAllConstructsAction()),

    SHOW_ALL_CONSTRUCTIONS(new ShowAllConstructionsAction()),
    SHOW_ALL_MATERIALS(new ShowAllMaterialsAction()),
    SHOW_DELETE_ITEM_PAGE(new ShowDeleteItemPageAction()),
    SHOW_EDIT_ITEM_PAGE(new ShowEditItemPageAction()),

    UPDATE_ITEM(new UpdateItemAction()),
    FIND_ITEM(new FindItemAction()),

    SHOW_ALL_USERS(new ShowAllUserAction()),
    SHOW_ALL_ROLES(new ShowAllRoleAction()),

    SHOW_ADMIN_PAGE(new ShowAdminPageAction()),
    GOTO_ADMIN_PAGE(new GotoAdminPageAction()),
    SHOW_ADD_ITEM_PAGE(new ShowAddItemPageAction()),
    SHOW_ITEMS_PAGE(new ShowAllItemsByPageAction()),

    SHOW_DELETE_USER_PAGE(new ShowDeleteUserPageAction()),

    FIND_USER(new FindUserAction()),

    DELETE_USER(new DeleteUserAction()),

    DELETE_ROLE(new DeleteRoleAction()),

    DELETE_ITEM(new DeleteItemAction()),

    DELETE_CONSTRUCT(new DeleteConstructAction()),

    DELETE_CONSTRUCTION(new DeleteConstructionAction()),
    DELETE_MATERIAL(new DeleteMaterialAction()),

    SHOW_USER_CHANGE_ROLE_PAGE(new ShowChangeRolePage()),

    GET_USER_DATA(new GetUserDataAction()),

    GET_ITEMS_DATA(new GetItemDataAction());


    Action action;

    ActionType(Action action) {
        this.action = action;
    }

    Action getAction() {
        return action;
    }

}
