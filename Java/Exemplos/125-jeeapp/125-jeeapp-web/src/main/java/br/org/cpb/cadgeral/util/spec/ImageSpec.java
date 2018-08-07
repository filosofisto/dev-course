package br.org.cpb.cadgeral.util.spec;

import br.org.cpb.io.UploadUtil;
import br.org.cpb.specification.Specification;
import org.primefaces.model.UploadedFile;

public class ImageSpec implements Specification<UploadedFile> {

    @Override
    public boolean isSatisfiedBy(UploadedFile uploadedFile, Object... objects) {
        return UploadUtil.isContentTypeMatchRegex(uploadedFile.getFileName(), UploadUtil.IMAGE);
    }
}