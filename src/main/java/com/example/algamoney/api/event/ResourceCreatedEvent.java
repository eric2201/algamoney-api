package com.example.algamoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreatedEvent extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private static final long SerialVersionUID = 1l;

    private HttpServletResponse response;

    private Long code;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, Long code) {
        super(source);
        this.response = response;
        this.code = code;

    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

}
