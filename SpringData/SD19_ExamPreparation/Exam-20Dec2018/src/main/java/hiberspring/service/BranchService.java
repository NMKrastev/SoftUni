package hiberspring.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BranchService {

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent) throws FileNotFoundException;
}
