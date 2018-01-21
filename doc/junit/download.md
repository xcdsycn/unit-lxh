# 关于下载文件的单元测试
涉及到 request response 的 mock,主要是 mocker 输出流

```java
public class DownloadTest {
    /**
    * mock response
*/
	MockHttpServletResponse Response = new MockHttpServletResponse();

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File tempFile;
    private File tempFileForException;
    private File tempDir;

    @Before
    public void before() throws IOException {
        tempFile = tempFolder.newFile("test.txt");
        tempDir = tempFolder.newFolder("test");
        tempFileForException = tempFolder.newFile("test1.txt");
        System.out.println("==> tempFile:" + tempFile.getCanonicalPath());
    }

    @Test
    public void testMPR() throws Exception {
        //critical
        HttpServletResponse response = mock(HttpServletResponse.class);
        final ServletOutputStream mockOutputStream = mock(ServletOutputStream.class);
        InputStream input = new FileInputStream(tempFile);
        mockOutputStream.write(IOUtils.toByteArray(input));
        doReturn(mockOutputStream).when(response).getOutputStream();
        Download.fileDownload(response, tempFile.getCanonicalPath(),tempFile.getName());
    }


    @Test(expected = NullPointerException.class)
    public void testCloseInput() throws IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        final ServletOutputStream mockOutputStream = mock(ServletOutputStream.class);
        InputStream input = new FileInputStream(tempFileForException);
        mockOutputStream.write(IOUtils.toByteArray(input));
        doReturn(mockOutputStream).when(response).getOutputStream();
        Download.fileDownload(response, "/a/b/test.txt","teset.txt");
    }

	@Test
	public void test() {
		URL url = DownloadTest.class.getResource("/com/mgzf/sdk/util/DownloadTest.class");
		File file = new File(url.getPath());
		try{
			Download.fileDownload(Response, file.getAbsolutePath(), file.getName());
		}catch(Exception e){
		}
		
	}
}
```