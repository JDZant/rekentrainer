//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Models;

import java.util.List;

public class SettingsModel {
    private List<Integer> selectedGroups;
    private Boolean hussleQuestions;
    private int sumAmount;

    public SettingsModel(List<Integer> selectedGroups, boolean hussleQuestions, int sumAmount) {
        this.selectedGroups = selectedGroups;
        this.hussleQuestions = hussleQuestions;
        this.sumAmount = sumAmount;
    }

    public List<Integer> getSelectedGroups() {
        return this.selectedGroups;
    }

    public void setSelectedGroups(List<Integer> selectedGroups) {
        this.selectedGroups = selectedGroups;
    }

    public Boolean getHussleQuestions() {
        return this.hussleQuestions;
    }

    public void setHussleQuestions(Boolean hussleQuestions) {
        this.hussleQuestions = hussleQuestions;
    }

    public int getSumAmount() {
        return this.sumAmount;
    }

    public void setSumAmount(int sumAmount) {
        this.sumAmount = sumAmount;
    }
}
