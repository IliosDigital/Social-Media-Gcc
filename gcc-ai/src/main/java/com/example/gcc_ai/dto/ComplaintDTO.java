package com.example.gcc_ai.dto;


import java.time.LocalDateTime;

public class ComplaintDTO {

    private String ticketId;
    private String translatedText;
    private Boolean isValidComplaint;
    private String sentiment;
    private String deptType;
    private Boolean emailSent;
    private LocalDateTime timestamp;
    private String postUrl;
    private String status;

    public ComplaintDTO(String ticketId, String translatedText, Boolean isValidComplaint, String sentiment,
                        String deptType, Boolean emailSent, LocalDateTime timestamp, String postUrl, String status) {
        this.ticketId = ticketId;
        this.translatedText = translatedText;
        this.isValidComplaint = isValidComplaint;
        this.sentiment = sentiment;
        this.deptType = deptType;
        this.emailSent = emailSent;
        this.timestamp = timestamp;
        this.postUrl = postUrl;
        this.status = status;
    }

    // Getters only (DTOs usually don't need setters)
    public String getTicketId() { return ticketId; }
    public String getTranslatedText() { return translatedText; }
    public Boolean getIsValidComplaint() { return isValidComplaint; }
    public String getSentiment() { return sentiment; }
    public String getDeptType() { return deptType; }
    public Boolean getEmailSent() { return emailSent; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getPostUrl() { return postUrl; }
    public String getStatus() {
        return status;
    }

}
