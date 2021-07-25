package com.sujan.task.dto;

public class SucessDto {

    private boolean sucess;

    public SucessDto(boolean sucess) {
        this.sucess = sucess;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public SucessDto() {
    }
}
