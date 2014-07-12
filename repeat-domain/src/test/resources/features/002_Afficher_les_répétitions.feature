#language: fr
Fonctionnalité: Afficher la liste de mes répétitions
  En tant qu'utilisateur,
  je peux afficher la liste de mes répétitions avec leur prochaine date
  afin de voir les prochaines échéances

  Scénario: Afficher mes répétitions
    Etant donné que je suis un utilisateur
    Et que je créé les répétitions périodiques suivantes :
      | description            | periode de répétition | date de début |
      | répétition de 10 jours | 10                    | 01/01/2020    |
      | répétition de 5 jours  | 5                     | 01/01/2020    |
      | répétition de 2 jours  | 2                     | 02/01/2020    |
    Et que je créé les répétitions de fin de mois suivantes
      | description                      | nombre de jours avant la fin du mois |
      | répétition 3j avant fin du mois  | 3                                    |
      | répétition 24j avant fin du mois | 15                                   |

    Et que nous sommes le "03/01/2020"
    Lorsque je liste mes répétitions par ordre de prochaine date
    Alors j'obtiens les répétitions suivantes :
      | description                      |
      | répétition de 2 jours            |
      | répétition de 5 jours            |
      | répétition 24j avant fin du mois |
      | répétition de 10 jours           |
      | répétition 3j avant fin du mois  |
