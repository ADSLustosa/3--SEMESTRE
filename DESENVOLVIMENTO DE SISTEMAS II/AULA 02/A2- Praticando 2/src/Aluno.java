class Aluno {
	private String nome, curso, nivelCurso;
	private int anoGraduacao;
	private boolean bolsista, graduacao, trabalho;
	private double mensalidade, desconto;
	private String[] dadosTCC;

	public Aluno(String nome,
			String curso,
			String nivelCurso,
			int cod_matricula,
			boolean bolsista,
			boolean graduacao,
			boolean trabalho,
			int anoGraduacao,
			double mensalidade,
			double desconto,
			String[] dadosTCC) {
		this.nome = nome;
		this.curso = curso;
		this.nivelCurso = nivelCurso;
		this.bolsista = bolsista;
		this.graduacao = graduacao;
		this.trabalho = trabalho;
		this.anoGraduacao = anoGraduacao;
		this.mensalidade = mensalidade;
		this.desconto = desconto;
		this.dadosTCC = dadosTCC;
	}

	private double calcularMensalidade() {
		if (bolsista) {
			return mensalidade * (1 - desconto / 100);
		}
		return mensalidade;
	}

	private String formatarTrabalho() {
		if (!trabalho) {
			return "";
		}

		String tipoTrabalho = "";
		switch (nivelCurso) {
			case "Graduação":
				tipoTrabalho = "TCC";
				break;
			case "Lato sensu":
				tipoTrabalho = "Monografia";
				break;
			case "Mestrado":
				tipoTrabalho = "Dissertação";
				break;
			case "Doutorado":
				tipoTrabalho = "Tese";
				break;
		}

		return "Título do " + tipoTrabalho + ": " + dadosTCC[1] + "\n" +
				"Orientador(a): Prof. " + dadosTCC[0] + "\n" +
				"Nota: " + dadosTCC[2] + "\n";
	}

	private String formatarFinalizacaoCurso() {
		if (graduacao) {
			String infoFinalizacao = "Curso finalizado em " + anoGraduacao + "\n";
			infoFinalizacao += formatarTrabalho();
			return infoFinalizacao;
		}
		return "";
	}

	public String obterDadosAluno() {
		StringBuilder resp = new StringBuilder();
		resp.append("Aluno: ").append(this.nome).append("\n");
		resp.append("Curso: ").append(this.nivelCurso).append(" em ").append(this.curso).append("\n");

		if (bolsista) {
			resp.append("Bolsista com desconto de: ").append(desconto).append("%\n");
		}

		resp.append("Mensalidade: R$ ").append(calcularMensalidade()).append("\n");
		resp.append(formatarFinalizacaoCurso());

		return resp.toString();
	}
}

class Teste {
	public static void main(String args[]) {
		String[] dados1 = { null, null, null };
		Aluno aluno1 = new Aluno("Martin Fowler",
				"ADS",
				"Graduação",
				11223344,
				true,
				false,
				false,
				-1,
				920.50,
				20.5,
				dados1);

		String[] dados2 = { "Peter Coad", "Impacto da Refatoração", "9.5" };
		Aluno aluno2 = new Aluno("Kent Beck",
				"Computação Aplicada",
				"Mestrado",
				22334455,
				false,
				true,
				true,
				2019,
				2150.45,
				0,
				dados2);

		System.out.println(aluno1.obterDadosAluno());
		System.out.println(aluno2.obterDadosAluno());
	}
}