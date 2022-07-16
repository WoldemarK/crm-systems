package com.example.crmsystems.company.model;

public enum Role {
    /**
     * ADMIN - может создавать сотрудника, редактировать, удаление нет только архивация данных
     */
    ROLE_ADMIN,
    /**
     * DIRECTOR -  может создавать клиента редактировать,  удаление нет только архивация данных
     * Просматривать всех клиентов компании, просмотр по отдельному сотруднику
     */
    ROLE_DIRECTOR,
    /**
     * EMPLOYEE - может создавать клиента, редактирование данные,
     * удаление запрещено только пометка на удаление с указанием причины и архивация.
     * Так же мотет принимать от клиента заказы редактировать, удалять не может только пометка на
     * удаление и причину
     */
    ROLE_EMPLOYEE,
    /**
     * CLIENT - Клиент может оформить заказ у сотрудника, редактировать заказ, удалять не может
     */
    ROLE_CLIENT,
    /**
     * PROVIDER - продумать логику взаимодействия
     */
    ROLE_PROVIDER
}
