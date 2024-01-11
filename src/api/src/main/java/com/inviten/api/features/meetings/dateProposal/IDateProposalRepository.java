package com.inviten.api.features.meetings.dateProposal;

import java.util.List;

public interface IDateProposalRepository {

    DateProposal findOne(String meetingId, String proposalId);

    List<DateProposal> findByMeetingId(String meetingId);

    void addDateProposal(String meetingId, DateProposal dateProposal);

    void removeDateProposal(String meetingId, String proposalId);

    void addVote(String meetingId, String proposalId);

    void removeVote(String meetingId, String proposalId);

    void confirmDate(String meetingId, String proposalId);
}
