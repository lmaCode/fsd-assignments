export class Video {
  constructor(t:string, u:string){

    this.title=t;
    this.url=u;
    this.status="";
    this.approved=false;
    this.likes=0;
    this.unlike=0;
    this.currentStatus="";
    this.exitplayprogress=0;

  }
  id:number;
  title: string;
  url: string;
  status:string;
  approved:boolean;
  likes:number;
  unlike:number;
  currentStatus:string;
  exitplayprogress:number;
}
