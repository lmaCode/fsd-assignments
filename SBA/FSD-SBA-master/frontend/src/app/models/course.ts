export interface Course {
  id: number;
  mentorId: string;
  mentorName: string;
  skillId: string;
  skillName: string;
  startDate: Date;
  endDate: Date;
  fees: number;
  progress: number;
  status: string;
}
