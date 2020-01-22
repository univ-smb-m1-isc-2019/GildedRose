import java.util.List;

public class UdapteQuality {
    public void UdapteQuality(List<AdvancedItem> itemList) {

        for (AdvancedItem item : itemList) {
            udapteQ u = new udapteQ(item);
            udapteS s = new udapteS(item);
        }
    }
}
