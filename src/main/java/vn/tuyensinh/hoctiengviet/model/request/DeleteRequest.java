package vn.tuyensinh.hoctiengviet.model.request;

public class DeleteRequest {
    private Long[] ids;

    public DeleteRequest() {
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
