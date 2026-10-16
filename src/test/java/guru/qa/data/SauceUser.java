package guru.qa.data;

public enum SauceUser {
    STANDARD("standard_user"),
    PROBLEM("problem_user"),
    PERFORMANCE_GLITCH("performance_glitch_user"),
    ERROR("error_user"),
    VISUAL("visual_user"),
    LOCKED_OUT("locked_out_user");

    public final String login;

    SauceUser(String login) {
        this.login = login;
    }
}
