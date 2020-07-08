package nei.nei.crmZLI.model;

import java.util.List;

public interface Customer {
	Long getId();
	String getName();
	List<Memo> getMemos();
}
