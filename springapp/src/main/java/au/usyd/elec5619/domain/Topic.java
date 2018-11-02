package au.usyd.elec5619.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "topic")
public class Topic {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(name = "title")
    private String title;
    
    @Column(name = "replyCount")
    private int replyCount;

    @Column(name = "author")
    private String author;
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "appendix")
    private String appendix;
    
    public void removeReply(int nSerial)
    {
    	 String[] tempArray;

         /* given string will be split by the argument delimiter provided. */
         tempArray = appendix.split("#");
         
         String finalstring = "";
         
         for (int i = 0; i < tempArray.length; i++)
         {
        	 if (i == nSerial)
        	 {
        		 continue;
        	 }
        	 finalstring += tempArray[i];
        	 finalstring += "#";
         }
         
         appendix = finalstring;
         
         replyCount -= 1;

    }
    
    public void editReply(int nSerial, String strTime, String strContent)
    {
    	 String[] tempArray;

         /* given string will be split by the argument delimiter provided. */
         tempArray = appendix.split("#");
         
                  
         String target = tempArray[nSerial];
         
         int nIndex = target.indexOf('$');
         String tmp = target.substring(0, nIndex);
         
         String newStr = tmp + "$" + strTime + "$" + strContent + "$";
         
         String finalstring = "";
         
         for (int i = 0; i < tempArray.length; i++)
         {
        	 if (i == nSerial)
        	 {
        		 finalstring += newStr;
        		 finalstring += "#";
        	 }
        	 else
        	 {
            	 finalstring += tempArray[i];
            	 finalstring += "#";
        	 }

         }
         appendix = finalstring;

    }

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAppendix() {
		return appendix;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
}
