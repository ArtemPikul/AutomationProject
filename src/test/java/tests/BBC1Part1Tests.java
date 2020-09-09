package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BBC1Part1Tests extends BaseTest {

    private static final String EXPECTED_ARTICLE_HEADLINE = "Fire destroys Greece's largest migrant camp";
    private static final String[] EXPECTED_SECONDARY_ARTICLES_TITLES = new String[]{
            "US to withdraw 2,200 troops from Iraq within weeks",
            "Oxford vaccine trial paused as participant falls ill",
            "Police shoot autistic boy after mum calls for help",
            "Kardashians announce end of hit reality show"
    };


    @Test
    public void firstTestTask() {
        getHomePage().clickOnHeaderNewsLink();
        getBasePage().implicitlyWait(20);
        Assert.assertEquals(getNewsPage().getExpectedArticleHeadlineText(), EXPECTED_ARTICLE_HEADLINE);
    }

    @Test
    public void secondTestTask() {
        getHomePage().clickOnHeaderNewsLink();
        getBasePage().implicitlyWait(30);
        boolean result = true;
        for (int i = 0; i < 4; i++) {
            String actualTitle = getNewsPage().getSecondaryArticleHeadlinesLIst().get(i).getText();
            if (EXPECTED_SECONDARY_ARTICLES_TITLES[i].equals(actualTitle)) {
                result = false;
                System.out.println(EXPECTED_SECONDARY_ARTICLES_TITLES[i]);
                System.out.println(actualTitle);
                break;
            }
        }
        Assert.assertTrue(result);
    }

}
